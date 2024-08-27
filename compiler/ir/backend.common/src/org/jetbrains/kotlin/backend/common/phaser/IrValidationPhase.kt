/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.common.phaser

import org.jetbrains.kotlin.backend.common.*
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.config.IrVerificationMode
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

abstract class IrValidationPhase<Context : CommonBackendContext>(val context: Context) : ModuleLoweringPass {
    protected abstract val validatorConfig: IrValidatorConfig

    final override fun lower(irModule: IrModuleFragment) {
        val verificationMode = context.configuration.get(CommonConfigurationKeys.VERIFY_IR, IrVerificationMode.NONE)
        validateIr(context.messageCollector, verificationMode) {
            validate(irModule, phaseName = this@IrValidationPhase.javaClass.simpleName)
        }
    }

    protected abstract fun IrValidationContext.validate(irModule: IrModuleFragment, phaseName: String)
}

open class IrValidationBeforeLoweringPhase<Context : CommonBackendContext>(context: Context) : IrValidationPhase<Context>(context) {
    override val validatorConfig: IrValidatorConfig
        get() = IrValidatorConfig(
            checkTypes = false, // TODO: Re-enable checking types (KT-68663)
            checkValueScopes = true,
            checkTypeParameterScopes = false, // TODO: Re-enable checking out-of-scope type parameter usages (KT-69305)
            checkCrossFileFieldUsage = context.configuration.getBoolean(CommonConfigurationKeys.ENABLE_IR_VISIBILITY_CHECKS),
            checkVisibilities = context.configuration.getBoolean(CommonConfigurationKeys.ENABLE_IR_VISIBILITY_CHECKS),
        )

    override fun IrValidationContext.validate(irModule: IrModuleFragment, phaseName: String) {
        performBasicIrValidation(
            irModule,
            context.irBuiltIns,
            phaseName,
            validatorConfig,
        )
    }
}

class IrValidationAfterInliningOnlyPrivateFunctionsPhase<Context : CommonBackendContext>(
    context: Context,
    private val checkInlineFunctionCallSites: InlineFunctionUseSiteChecker
) : IrValidationPhase<Context>(context) {
    override val validatorConfig: IrValidatorConfig
        get() = IrValidatorConfig(
            checkTypes = false, // TODO: Re-enable checking types (KT-68663)
            checkVisibilities = false, // TODO: Enable checking visibilities (KT-69516)
            checkInlineFunctionUseSites = checkInlineFunctionCallSites,
        )

    override fun IrValidationContext.validate(irModule: IrModuleFragment, phaseName: String) {
        performBasicIrValidation(
            irModule,
            context.irBuiltIns,
            phaseName,
            validatorConfig,
        )
    }
}

class IrValidationAfterInliningAllFunctionsPhase<Context : CommonBackendContext>(
    context: Context,
    private val checkInlineFunctionCallSites: InlineFunctionUseSiteChecker? = null
) : IrValidationPhase<Context>(context) {

    override val validatorConfig: IrValidatorConfig
        get() = IrValidatorConfig(
            checkTypes = false, // TODO: Re-enable checking types (KT-68663)
            checkValueScopes = context.configuration.getBoolean(CommonConfigurationKeys.ENABLE_IR_VISIBILITY_CHECKS_AFTER_INLINING),
            checkCrossFileFieldUsage = context.configuration.getBoolean(CommonConfigurationKeys.ENABLE_IR_VISIBILITY_CHECKS_AFTER_INLINING),
            checkTypeParameterScopes = false,
            checkVisibilities = context.configuration.getBoolean(CommonConfigurationKeys.ENABLE_IR_VISIBILITY_CHECKS_AFTER_INLINING),
            checkInlineFunctionUseSites = checkInlineFunctionCallSites
        )

    override fun IrValidationContext.validate(irModule: IrModuleFragment, phaseName: String) {
        performBasicIrValidation(
            irModule,
            context.irBuiltIns,
            phaseName,
            validatorConfig,
        )
    }
}

open class IrValidationAfterLoweringPhase<Context : CommonBackendContext>(context: Context) : IrValidationPhase<Context>(context) {
    override val validatorConfig: IrValidatorConfig
        get() = IrValidatorConfig()

    override fun IrValidationContext.validate(irModule: IrModuleFragment, phaseName: String) {
        performBasicIrValidation(irModule, context.irBuiltIns, phaseName, validatorConfig)
    }
}
