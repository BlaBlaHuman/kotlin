/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.symbols;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.symbols.AbstractSingleSymbolByPsiTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/symbols/singleSymbolByPsi")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleSingleSymbolByPsiTestGenerated extends AbstractSingleSymbolByPsiTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInSingleSymbolByPsi() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/singleSymbolByPsi"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("catchWithName.kt")
  public void testCatchWithName() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/catchWithName.kt");
  }

  @Test
  @TestMetadata("catchWithoutName.kt")
  public void testCatchWithoutName() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/catchWithoutName.kt");
  }

  @Test
  @TestMetadata("ExpandedParameterType.kt")
  public void testExpandedParameterType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/ExpandedParameterType.kt");
  }

  @Test
  @TestMetadata("ExpandedReturnType.kt")
  public void testExpandedReturnType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/ExpandedReturnType.kt");
  }

  @Test
  @TestMetadata("file.kt")
  public void testFile() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/file.kt");
  }

  @Test
  @TestMetadata("fileWithAnnotations.kt")
  public void testFileWithAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/fileWithAnnotations.kt");
  }

  @Test
  @TestMetadata("functionFromInitBlock.kt")
  public void testFunctionFromInitBlock() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/functionFromInitBlock.kt");
  }

  @Test
  @TestMetadata("functionWithReceiverAnnotation.kt")
  public void testFunctionWithReceiverAnnotation() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/functionWithReceiverAnnotation.kt");
  }

  @Test
  @TestMetadata("getterWithAnnotations.kt")
  public void testGetterWithAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/getterWithAnnotations.kt");
  }

  @Test
  @TestMetadata("getterWithReceiverAndAnnotations.kt")
  public void testGetterWithReceiverAndAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/getterWithReceiverAndAnnotations.kt");
  }

  @Test
  @TestMetadata("lambdaParameterWithName.kt")
  public void testLambdaParameterWithName() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/lambdaParameterWithName.kt");
  }

  @Test
  @TestMetadata("lambdaParameterWithoutName.kt")
  public void testLambdaParameterWithoutName() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/lambdaParameterWithoutName.kt");
  }

  @Test
  @TestMetadata("nestedTypeAnnotationWithTypeAlias.kt")
  public void testNestedTypeAnnotationWithTypeAlias() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/nestedTypeAnnotationWithTypeAlias.kt");
  }

  @Test
  @TestMetadata("nestedTypeAnnotationWithTypeAliasAsAnnotation.kt")
  public void testNestedTypeAnnotationWithTypeAliasAsAnnotation() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/nestedTypeAnnotationWithTypeAliasAsAnnotation.kt");
  }

  @Test
  @TestMetadata("propertyFromInitBlock.kt")
  public void testPropertyFromInitBlock() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyFromInitBlock.kt");
  }

  @Test
  @TestMetadata("propertyFromWhenExpression.kt")
  public void testPropertyFromWhenExpression() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyFromWhenExpression.kt");
  }

  @Test
  @TestMetadata("propertyWithAnnotations.kt")
  public void testPropertyWithAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyWithAnnotations.kt");
  }

  @Test
  @TestMetadata("propertyWithAnnotationsAndAccessors.kt")
  public void testPropertyWithAnnotationsAndAccessors() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyWithAnnotationsAndAccessors.kt");
  }

  @Test
  @TestMetadata("propertyWithDelegateAndAnnotations.kt")
  public void testPropertyWithDelegateAndAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyWithDelegateAndAnnotations.kt");
  }

  @Test
  @TestMetadata("propertyWithReceiverAnnotation.kt")
  public void testPropertyWithReceiverAnnotation() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/propertyWithReceiverAnnotation.kt");
  }

  @Test
  @TestMetadata("setterWithAnnotations.kt")
  public void testSetterWithAnnotations() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/setterWithAnnotations.kt");
  }

  @Test
  @TestMetadata("tailrecFunction.kt")
  public void testTailrecFunction() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/tailrecFunction.kt");
  }

  @Test
  @TestMetadata("typeAnnotationWithArgument.kt")
  public void testTypeAnnotationWithArgument() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationWithArgument.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnFunctionParameterType.kt")
  public void testTypeAnnotationsOnFunctionParameterType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnFunctionParameterType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnFunctionReceiverType.kt")
  public void testTypeAnnotationsOnFunctionReceiverType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnFunctionReceiverType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnFunctionalTypeWithTypeAlias.kt")
  public void testTypeAnnotationsOnFunctionalTypeWithTypeAlias() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnFunctionalTypeWithTypeAlias.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnPropertyGetterReturnType.kt")
  public void testTypeAnnotationsOnPropertyGetterReturnType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnPropertyGetterReturnType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnPropertyReceiverType.kt")
  public void testTypeAnnotationsOnPropertyReceiverType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnPropertyReceiverType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnPropertyReturnType.kt")
  public void testTypeAnnotationsOnPropertyReturnType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnPropertyReturnType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnPropertySetterParameterType.kt")
  public void testTypeAnnotationsOnPropertySetterParameterType() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnPropertySetterParameterType.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnPropertySetterParameterTypeWithAnotherAnnotation.kt")
  public void testTypeAnnotationsOnPropertySetterParameterTypeWithAnotherAnnotation() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnPropertySetterParameterTypeWithAnotherAnnotation.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnSuperClassCall.kt")
  public void testTypeAnnotationsOnSuperClassCall() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnSuperClassCall.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnSuperClassCallOnAnonymousObject.kt")
  public void testTypeAnnotationsOnSuperClassCallOnAnonymousObject() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnSuperClassCallOnAnonymousObject.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnSuperInterface.kt")
  public void testTypeAnnotationsOnSuperInterface() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnSuperInterface.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsOnSuperInterfaceOnAnonymousObject.kt")
  public void testTypeAnnotationsOnSuperInterfaceOnAnonymousObject() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsOnSuperInterfaceOnAnonymousObject.kt");
  }

  @Test
  @TestMetadata("typeAnnotationsWithTypeAlias.kt")
  public void testTypeAnnotationsWithTypeAlias() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/typeAnnotationsWithTypeAlias.kt");
  }

  @Test
  @TestMetadata("valueClass.kt")
  public void testValueClass() {
    runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/valueClass.kt");
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts")
  @TestDataPath("$PROJECT_ROOT")
  public class Contracts {
    @Test
    public void testAllFilesPresentInContracts() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("booleanConstReferenceInImplies.kt")
    public void testBooleanConstReferenceInImplies() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/booleanConstReferenceInImplies.kt");
    }

    @Test
    @TestMetadata("booleanExprContract.kt")
    public void testBooleanExprContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/booleanExprContract.kt");
    }

    @Test
    @TestMetadata("callsInPlaceAtLeastOnceContract.kt")
    public void testCallsInPlaceAtLeastOnceContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/callsInPlaceAtLeastOnceContract.kt");
    }

    @Test
    @TestMetadata("callsInPlaceAtMostOnceContract.kt")
    public void testCallsInPlaceAtMostOnceContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/callsInPlaceAtMostOnceContract.kt");
    }

    @Test
    @TestMetadata("callsInPlaceExactlyOnceContract.kt")
    public void testCallsInPlaceExactlyOnceContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/callsInPlaceExactlyOnceContract.kt");
    }

    @Test
    @TestMetadata("callsInPlaceUnknownContract.kt")
    public void testCallsInPlaceUnknownContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/callsInPlaceUnknownContract.kt");
    }

    @Test
    @TestMetadata("invalidContractParameterPassedToReturns.kt")
    public void testInvalidContractParameterPassedToReturns() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/invalidContractParameterPassedToReturns.kt");
    }

    @Test
    @TestMetadata("isInstancePredicateContract.kt")
    public void testIsInstancePredicateContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/isInstancePredicateContract.kt");
    }

    @Test
    @TestMetadata("logicalNotContract.kt")
    public void testLogicalNotContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/logicalNotContract.kt");
    }

    @Test
    @TestMetadata("referenceBooleanReceiverInContract.kt")
    public void testReferenceBooleanReceiverInContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/referenceBooleanReceiverInContract.kt");
    }

    @Test
    @TestMetadata("referenceReceiverInContract.kt")
    public void testReferenceReceiverInContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/referenceReceiverInContract.kt");
    }

    @Test
    @TestMetadata("returnsContract.kt")
    public void testReturnsContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/returnsContract.kt");
    }

    @Test
    @TestMetadata("returnsFalseContract.kt")
    public void testReturnsFalseContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/returnsFalseContract.kt");
    }

    @Test
    @TestMetadata("returnsNotNullContract.kt")
    public void testReturnsNotNullContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/returnsNotNullContract.kt");
    }

    @Test
    @TestMetadata("returnsNullContract.kt")
    public void testReturnsNullContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/returnsNullContract.kt");
    }

    @Test
    @TestMetadata("returnsTrueContract.kt")
    public void testReturnsTrueContract() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/returnsTrueContract.kt");
    }

    @Test
    @TestMetadata("twoContracts.kt")
    public void testTwoContracts() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/contracts/twoContracts.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring")
  @TestDataPath("$PROJECT_ROOT")
  public class Destructuring {
    @Test
    public void testAllFilesPresentInDestructuring() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("destructuringDeclaration.kt")
    public void testDestructuringDeclaration() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/destructuringDeclaration.kt");
    }

    @Test
    @TestMetadata("destructuringDeclarationInLambda.kt")
    public void testDestructuringDeclarationInLambda() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/destructuringDeclarationInLambda.kt");
    }

    @Test
    @TestMetadata("destructuringDeclarationMutable.kt")
    public void testDestructuringDeclarationMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/destructuringDeclarationMutable.kt");
    }

    @Test
    @TestMetadata("destructuringDeclarationParameterInLambda.kt")
    public void testDestructuringDeclarationParameterInLambda() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/destructuringDeclarationParameterInLambda.kt");
    }

    @Test
    @TestMetadata("entryInDestructuringDeclaration.kt")
    public void testEntryInDestructuringDeclaration() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/entryInDestructuringDeclaration.kt");
    }

    @Test
    @TestMetadata("entryInDestructuringDeclarationMutable.kt")
    public void testEntryInDestructuringDeclarationMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/entryInDestructuringDeclarationMutable.kt");
    }

    @Test
    @TestMetadata("entryInDestructuringDeclarationParameterInLambda.kt")
    public void testEntryInDestructuringDeclarationParameterInLambda() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/entryInDestructuringDeclarationParameterInLambda.kt");
    }

    @Test
    @TestMetadata("entryUnderscoreInDestructuringDeclaration.kt")
    public void testEntryUnderscoreInDestructuringDeclaration() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/entryUnderscoreInDestructuringDeclaration.kt");
    }

    @Test
    @TestMetadata("entryUnderscoreInDestructuringDeclarationParameterInLambda.kt")
    public void testEntryUnderscoreInDestructuringDeclarationParameterInLambda() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/destructuring/entryUnderscoreInDestructuringDeclarationParameterInLambda.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors")
  @TestDataPath("$PROJECT_ROOT")
  public class Errors {
    @Test
    public void testAllFilesPresentInErrors() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("anonymousObjectInInvalidPosition.kt")
    public void testAnonymousObjectInInvalidPosition() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/anonymousObjectInInvalidPosition.kt");
    }

    @Test
    @TestMetadata("incompleteFunctionTypeParameter.kt")
    public void testIncompleteFunctionTypeParameter() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/incompleteFunctionTypeParameter.kt");
    }

    @Test
    @TestMetadata("initWithAnnotations.kt")
    public void testInitWithAnnotations() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/initWithAnnotations.kt");
    }

    @Test
    @TestMetadata("memberLevelDestructuringDeclaration.kt")
    public void testMemberLevelDestructuringDeclaration() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/memberLevelDestructuringDeclaration.kt");
    }

    @Test
    @TestMetadata("memberLevelDestructuringDeclarationEntry.kt")
    public void testMemberLevelDestructuringDeclarationEntry() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/memberLevelDestructuringDeclarationEntry.kt");
    }

    @Test
    @TestMetadata("memberLevelDestructuringDeclarationEntryMutable.kt")
    public void testMemberLevelDestructuringDeclarationEntryMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/memberLevelDestructuringDeclarationEntryMutable.kt");
    }

    @Test
    @TestMetadata("memberLevelDestructuringDeclarationMutable.kt")
    public void testMemberLevelDestructuringDeclarationMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/memberLevelDestructuringDeclarationMutable.kt");
    }

    @Test
    @TestMetadata("objectWithTypeArgsAsExpression.kt")
    public void testObjectWithTypeArgsAsExpression() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/objectWithTypeArgsAsExpression.kt");
    }

    @Test
    @TestMetadata("topLevelDestructuringDeclaration.kt")
    public void testTopLevelDestructuringDeclaration() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/topLevelDestructuringDeclaration.kt");
    }

    @Test
    @TestMetadata("topLevelDestructuringDeclarationEntry.kt")
    public void testTopLevelDestructuringDeclarationEntry() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/topLevelDestructuringDeclarationEntry.kt");
    }

    @Test
    @TestMetadata("topLevelDestructuringDeclarationEntryMutable.kt")
    public void testTopLevelDestructuringDeclarationEntryMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/topLevelDestructuringDeclarationEntryMutable.kt");
    }

    @Test
    @TestMetadata("topLevelDestructuringDeclarationMutable.kt")
    public void testTopLevelDestructuringDeclarationMutable() {
      runTest("analysis/analysis-api/testData/symbols/singleSymbolByPsi/errors/topLevelDestructuringDeclarationMutable.kt");
    }
  }
}
