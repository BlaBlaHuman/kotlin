/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.containingDeclarationProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.containingDeclarationProvider.AbstractContainingDeclarationProviderByReferenceTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisScriptSourceModuleContainingDeclarationProviderByReferenceTestGenerated extends AbstractContainingDeclarationProviderByReferenceTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.ScriptSource,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInContainingDeclarationByReference() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference"), Pattern.compile("^(.+)\\.kts$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated")
  @TestDataPath("$PROJECT_ROOT")
  public class DataClassGenerated {
    @Test
    public void testAllFilesPresentInDataClassGenerated() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated"), Pattern.compile("^(.+)\\.kts$"), null, true);
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated/library")
    @TestDataPath("$PROJECT_ROOT")
    public class Library {
      @Test
      public void testAllFilesPresentInLibrary() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated/library"), Pattern.compile("^(.+)\\.kts$"), null, true);
      }
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated/source")
    @TestDataPath("$PROJECT_ROOT")
    public class Source {
      @Test
      public void testAllFilesPresentInSource() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/dataClassGenerated/source"), Pattern.compile("^(.+)\\.kts$"), null, true);
      }
    }
  }
}
