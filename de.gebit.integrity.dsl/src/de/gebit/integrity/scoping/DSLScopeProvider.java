/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package de.gebit.integrity.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.Import;
import de.gebit.integrity.dsl.JavaConstantReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.PackageStatement;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultName;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.Statement;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.JavaTypeUtil;
import de.gebit.integrity.utils.ParamAnnotationTypeTriplet;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.ResultFieldTuple;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * The qualified name converter.
	 */
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/**
	 * Limits the fixed parameter names to those defined in a fixture method signature.
	 * 
	 * @param aParameterName
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedParameterName_annotation(FixedParameterName aParameterName, EReference aRef) {
		MethodReference tempMethodRef = null;
		if (aParameterName.eContainer() instanceof Parameter) {
			Parameter tempParameter = (Parameter) aParameterName.eContainer();

			if (tempParameter.eContainer() instanceof Test) {
				tempMethodRef = ((Test) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			} else if (tempParameter.eContainer() instanceof Call) {
				tempMethodRef = ((Call) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			} else if (tempParameter.eContainer() instanceof TableTest) {
				tempMethodRef = ((TableTest) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			}
		} else if (aParameterName.eContainer() instanceof ParameterTableHeader) {
			ParameterTableHeader tempParameterHeader = (ParameterTableHeader) aParameterName.eContainer();

			if (tempParameterHeader.eContainer() instanceof TableTest) {
				tempMethodRef = ((TableTest) tempParameterHeader.eContainer()).getDefinition().getFixtureMethod();
			}
		} else if (aParameterName.eContainer() instanceof ForkParameter) {
			ForkParameter tempForkParameter = (ForkParameter) aParameterName.eContainer();
			ForkDefinition tempForkDef = (ForkDefinition) tempForkParameter.eContainer();

			while (tempForkDef.getBaseFork() != null) {
				tempForkDef = tempForkDef.getBaseFork();
			}

			if (tempForkDef.getForkerClass() != null
					&& (tempForkDef.getForkerClass().getType() instanceof JvmGenericType)) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<ParamAnnotationTypeTriplet> tempParamList = IntegrityDSLUtil.getAllParamNamesFromFork(tempForkDef);

				for (ParamAnnotationTypeTriplet tempParam : tempParamList) {
					tempList.add(EObjectDescription.create(tempParam.getParamName(), tempParam.getAnnotation()));
				}

				return new SimpleScope(tempList);
			}
		}

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ParamAnnotationTypeTriplet> tempParamList = IntegrityDSLUtil
					.getAllParamNamesFromFixtureMethod(tempMethodRef);
			for (ParamAnnotationTypeTriplet tempParam : tempParamList) {
				tempList.add(EObjectDescription.create(tempParam.getParamName(), tempParam.getAnnotation()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limits the fixture method references to actually existing methods with the necessary annotation.
	 * 
	 * 
	 * @param aMethodRef
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_MethodReference_method(MethodReference aMethodRef, EReference aRef) {
		JvmType tempType = aMethodRef.getType();
		List<IEObjectDescription> tempDescriptions = new ArrayList<IEObjectDescription>();

		if (tempType instanceof JvmGenericType) {
			JvmGenericType tempTypeInFocus = (JvmGenericType) tempType;

			while (tempTypeInFocus != null) {
				for (JvmMember tempMember : tempTypeInFocus.getMembers()) {
					if (tempMember instanceof JvmOperation
							&& ((JvmOperation) tempMember).getVisibility() == JvmVisibility.PUBLIC) {
						boolean tempIsFixtureMethod = false;
						for (JvmAnnotationReference tempAnnotation : tempMember.getAnnotations()) {
							if (FixtureMethod.class.getName()
									.equals(tempAnnotation.getAnnotation().getQualifiedName())) {
								tempIsFixtureMethod = true;
								break;
							}
						}
						if (tempIsFixtureMethod) {
							tempDescriptions.add(EObjectDescription.create(
									QualifiedName.create(((JvmOperation) tempMember).getSimpleName()), tempMember));
						}
					}
				}

				JvmGenericType tempOldType = tempTypeInFocus;
				tempTypeInFocus = null;
				for (JvmTypeReference tempSuperType : tempOldType.getSuperTypes()) {
					if ((tempSuperType.getType() instanceof JvmGenericType)
							&& !((JvmGenericType) tempSuperType.getType()).isInterface()) {
						tempTypeInFocus = (JvmGenericType) tempSuperType.getType();
						break;
					}
				}
			}
		}
		return new SimpleScope(tempDescriptions);
	}

	/**
	 * Limits Java constant references to "public static final" ones.
	 * 
	 * @param aConstantRef
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_JavaConstantReference_constant(JavaConstantReference aConstantRef, EReference aRef) {
		JvmType tempType = aConstantRef.getType();
		List<IEObjectDescription> tempDescriptions = new ArrayList<IEObjectDescription>();

		if (tempType instanceof JvmGenericType) {
			recursivelyFindJavaConstants((JvmGenericType) tempType, tempDescriptions);
		}
		return new SimpleScope(tempDescriptions);
	}

	private void recursivelyFindJavaConstants(JvmGenericType aType, List<IEObjectDescription> someDescriptions) {
		for (JvmField tempField : aType.getDeclaredFields()) {
			if (!(tempField instanceof JvmEnumerationLiteral) && tempField.isStatic() && tempField.isFinal()
					&& tempField.getVisibility() == JvmVisibility.PUBLIC) {
				someDescriptions
						.add(EObjectDescription.create(QualifiedName.create(tempField.getSimpleName()), tempField));
			}
		}

		for (JvmTypeReference tempSuperType : aType.getSuperTypes()) {
			if (tempSuperType.getType() instanceof JvmGenericType) {
				recursivelyFindJavaConstants((JvmGenericType) tempSuperType.getType(), someDescriptions);
			}
		}
	}

	/**
	 * Limits suite parameters to actually defined parameters.
	 * 
	 * @param aParameter
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_SuiteParameter_name(SuiteParameter aParameter, EReference aRef) {
		SuiteDefinition tempSuiteDef = (SuiteDefinition) ((Suite) aParameter.eContainer()).getDefinition();

		if (tempSuiteDef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			for (VariableOrConstantEntity tempParam : ParameterUtil
					.getVariableEntitiesForSuiteParameters(tempSuiteDef)) {
				tempList.add(EObjectDescription.create(tempParam.getName(), tempParam));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Determine valid enumeration values for the provided parameter name of the provided fixture method reference.
	 * 
	 * @param aMethodRef
	 * @param aParameterName
	 * @return
	 */
	protected IScope determineParameterEnumValueScope(MethodReference aMethodRef, ParameterName aParameterName) {
		if (aParameterName instanceof FixedParameterName) {
			JvmAnnotationReference tempAnnotationRef = ((FixedParameterName) aParameterName).getAnnotation();

			if (aMethodRef != null && tempAnnotationRef != null) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<JvmEnumerationLiteral> tempLiteralList = IntegrityDSLUtil
						.getAllEnumLiteralsFromFixtureMethodParam(aMethodRef, tempAnnotationRef);
				if (tempLiteralList != null) {
					for (JvmEnumerationLiteral tempLiteral : tempLiteralList) {
						tempList.add(EObjectDescription.create(tempLiteral.getSimpleName(), tempLiteral));
					}

					return new SimpleScope(tempList);
				}
			}
		} else {
			// TODO add arbitrary parameter name path
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Determine valid enumeration values for the default result type of the provided fixture method reference.
	 * 
	 * @param aMethodRef
	 * @return
	 */
	protected IScope determineDefaultResultEnumValueScope(MethodReference aMethodRef) {
		if (aMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<JvmEnumerationLiteral> tempLiteralList = JavaTypeUtil
					.getAllEnumLiteralsFromJvmType(aMethodRef.getMethod().getReturnType().getType());
			if (tempLiteralList != null) {
				for (JvmEnumerationLiteral tempLiteral : tempLiteralList) {
					tempList.add(EObjectDescription.create(tempLiteral.getSimpleName(), tempLiteral));
				}

				return new SimpleScope(tempList);
			}
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Determine valid enumeration values for the default result type of the provided fixture method reference.
	 * 
	 * @param aMethodRef
	 * @return
	 */
	protected IScope determineNamedResultEnumValueScope(MethodReference aMethodRef, JvmField aField) {
		if (aMethodRef != null && aField != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();

			List<JvmEnumerationLiteral> tempLiteralList = JavaTypeUtil
					.getAllEnumLiteralsFromJvmType(aField.getType().getType());
			if (tempLiteralList != null) {
				for (JvmEnumerationLiteral tempLiteral : tempLiteralList) {
					tempList.add(EObjectDescription.create(tempLiteral.getSimpleName(), tempLiteral));
				}

				return new SimpleScope(tempList);
			}
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limits enumeration values in parameters to actually existent enumeration literals.
	 * 
	 * @param aParameter
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(Parameter aParameter, EReference aRef) {
		MethodReference tempMethodRef = null;
		if (aParameter.eContainer() instanceof Test) {
			tempMethodRef = ((Test) aParameter.eContainer()).getDefinition().getFixtureMethod();
		} else if (aParameter.eContainer() instanceof Call) {
			tempMethodRef = ((Call) aParameter.eContainer()).getDefinition().getFixtureMethod();
		} else if (aParameter.eContainer() instanceof TableTest) {
			tempMethodRef = ((TableTest) aParameter.eContainer()).getDefinition().getFixtureMethod();
		}

		return determineParameterEnumValueScope(tempMethodRef, aParameter.getName());
	}

	/**
	 * Lists enumeration values in tabletest parameters (which can be actual parameters or results, depending on the
	 * header of the column).
	 * 
	 * @param aParameter
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(ParameterTableValue aParameter, EReference aRef) {
		MethodReference tempMethodRef = ((TableTest) aParameter.eContainer().eContainer()).getDefinition()
				.getFixtureMethod();

		EObject tempTableHeader = IntegrityDSLUtil.getTableHeaderForTableCell(aParameter);

		if (tempTableHeader instanceof ParameterTableHeader) {
			// it's a specific parameter column
			return determineParameterEnumValueScope(tempMethodRef, ((ParameterTableHeader) tempTableHeader).getName());
		} else if (tempTableHeader instanceof ResultTableHeader) {
			// it's a named result
			ResultName tempResultName = ((ResultTableHeader) tempTableHeader).getName();
			if (tempResultName instanceof FixedResultName) {
				return determineNamedResultEnumValueScope(tempMethodRef, ((FixedResultName) tempResultName).getField());
			}
		} else if (tempTableHeader instanceof TableTest) {
			// it is the default result column
			return determineDefaultResultEnumValueScope(tempMethodRef);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit enum values in test results to actually existent enumeration literals.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(Test aTest, EReference aRef) {
		return determineDefaultResultEnumValueScope(aTest.getDefinition().getFixtureMethod());
	}

	/**
	 * Limit enum values in named test results to actually existent enumeration literals.
	 * 
	 * @param aNamedResult
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(NamedResult aNamedResult, EReference aRef) {
		ResultName tempResultName = aNamedResult.getName();
		if (tempResultName instanceof FixedResultName) {
			if (aNamedResult.eContainer() instanceof Test) {
				return determineNamedResultEnumValueScope(
						((Test) aNamedResult.eContainer()).getDefinition().getFixtureMethod(),
						((FixedResultName) tempResultName).getField());
			}
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(Test aTest, EReference aRef) {
		MethodReference tempMethodRef = aTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aCall
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(Call aCall, EReference aRef) {
		MethodReference tempMethodRef = aCall.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aTableTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(TableTest aTableTest, EReference aRef) {
		MethodReference tempMethodRef = aTableTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit result variables for calls to actual variables.
	 * 
	 * @param aCall
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_VariableVariable_name(Call aCall, EReference aRef) {
		// fetch the host suite of the call
		SuiteDefinition tempHostSuite = (SuiteDefinition) aCall.eContainer();

		return determineVariableScope(aCall, tempHostSuite);
	}

	/**
	 * Prevents variables in parameters from being influenced by {@link #scope_Variable_name(Call, EReference)}, and
	 * filters out variables defined as suite parameters in other suites.
	 * 
	 * @param aParam
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(Parameter aParam, EReference aRef) {
		// fetch the host suite of the parameter (should be correct for calls, tabletests and tests)
		SuiteDefinition tempHostSuite = (SuiteDefinition) aParam.eContainer().eContainer();

		return determineVariableScope(aParam, tempHostSuite);
	}

	/**
	 * Determines variables/constants in scope for table test parameters or results.
	 * 
	 * @param aTableTestRow
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(TableTest aTableTest, EReference aRef) {
		SuiteDefinition tempHostSuite = (SuiteDefinition) aTableTest.eContainer();

		return determineVariableScope(aTableTest, tempHostSuite);
	}

	/**
	 * Determines variables/constants in scope for test parameters or results.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(Test aTest, EReference aRef) {
		SuiteDefinition tempHostSuite = (SuiteDefinition) aTest.eContainer();

		return determineVariableScope(aTest, tempHostSuite);
	}

	/**
	 * Determines variables/constants in scope for suite parameters.
	 * 
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(Suite aSuite, EReference aRef) {
		SuiteDefinition tempHostSuite = (SuiteDefinition) aSuite.eContainer();

		return determineVariableScope(aSuite, tempHostSuite);
	}

	/**
	 * <<<<<<< HEAD ======= Determines variables/constants in scope for variable definitions.
	 * 
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(VariableDefinition aVariableDefinition, EReference aRef) {
		EObject tempParent = aVariableDefinition.eContainer();

		if (tempParent instanceof SuiteDefinition) {
			return determineVariableScope(aVariableDefinition, (SuiteDefinition) tempParent);
		} else if (tempParent instanceof PackageDefinition) {
			return determineVariableScope((PackageDefinition) tempParent);
		}

		return null;
	}

	/**
	 * Determines variables/constants in scope for constant definitions.
	 * 
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(ConstantDefinition aConstantDefinition, EReference aRef) {
		EObject tempParent = aConstantDefinition.eContainer();

		if (tempParent instanceof SuiteDefinition) {
			return determineVariableScope(aConstantDefinition, (SuiteDefinition) tempParent);
		} else if (tempParent instanceof PackageDefinition) {
			return determineVariableScope((PackageDefinition) tempParent);
		}

		return null;
	}

	/**
	 * >>>>>>> v0.15.x_bugfix This basically performs a default import on everything in the local file by adding another
	 * scope entry for all suite definitions in the current file.
	 * 
	 * @param aSuite
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Suite_definition(Suite aSuite, EReference aRef) {
		IScope tempScope = super.delegateGetScope(aSuite, aRef);

		List<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
		Model tempRootModel = IntegrityDSLUtil.findUpstreamContainer(Model.class, aSuite);
		// Add definitions from current file (fully qualified and in short form, both are allowed - fully qualified was
		// already added by super method, short form is now added here)
		for (Statement tempStatement : tempRootModel.getStatements()) {
			if (tempStatement instanceof PackageDefinition) {
				for (PackageStatement tempPackageStatement : ((PackageDefinition) tempStatement).getStatements()) {
					if (tempPackageStatement instanceof SuiteDefinition) {
						tempList.add(EObjectDescription.create(((SuiteDefinition) tempPackageStatement).getName(),
								tempPackageStatement));
					}
				}
			}
		}

		return filterPrivateElements(new SimpleScope(tempScope, tempList), aSuite);
	}

	/**
	 * Filters out private forks.
	 * 
	 * @param aSuite
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Suite_fork(Suite aSuite, EReference aRef) {
		IScope tempScope = super.delegateGetScope(aSuite, aRef);

		List<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
		Model tempRootModel = IntegrityDSLUtil.findUpstreamContainer(Model.class, aSuite);
		// Add definitions from current file (fully qualified and in short form, both are allowed - fully qualified was
		// already added by super method, short form is now added here)
		for (Statement tempStatement : tempRootModel.getStatements()) {
			if (tempStatement instanceof PackageDefinition) {
				for (PackageStatement tempPackageStatement : ((PackageDefinition) tempStatement).getStatements()) {
					if (tempPackageStatement instanceof ForkDefinition) {
						tempList.add(EObjectDescription.create(((ForkDefinition) tempPackageStatement).getName(),
								tempPackageStatement));
					}
				}
			}
		}

		return filterPrivateElements(new SimpleScope(tempScope, tempList), aSuite);
	}

	/**
	 * Determines the scope of SuiteReturns.
	 * 
	 * @param aSuite
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_SuiteReturn_name(Suite aSuite, EReference aRef) {
		SuiteDefinition tempSuiteDefinition = aSuite.getDefinition();

		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
		if (tempSuiteDefinition != null) {
			for (SuiteReturnDefinition tempDefinition : tempSuiteDefinition.getReturn()) {
				tempList.add(EObjectDescription.create(tempDefinition.getName().getName(), tempDefinition));
			}
		}
		return new SimpleScope(tempList);
	}

	/**
	 * A small cache for visible global variables. Determining these is rather expensive, thus they're cached as long as
	 * only one model (file) is being scoped or as long as a full build cycle does not switch to a different project
	 * (just matters inside Eclipse, where project dependencies may lead to different scopes).
	 */
	private static Map<String, List<IEObjectDescription>> cachedVisibleGlobalVariablesMap = new HashMap<>();

	/**
	 * See {@link #cachedVisibleGlobalVariablesMap}.
	 */
	private static List<IEObjectDescription> cachedVisibleGlobalVariables = new ArrayList<>();

	/**
	 * Caches imported versions of global variables.
	 */
	private static List<IEObjectDescription> cachedImportedGlobalVariables = new ArrayList<>();

	/**
	 * Used to invalidate the cache in case of incremental build cycles when we leave the current document.
	 */
	private static String cachedVisibleGlobalVariablesCurrentModel;

	/**
	 * This is used to invalidate the {@link #cachedVisibleGlobalVariablesMap} in case of full build cycles as soon as
	 * scoping is done for a different eclipse project.
	 */
	private static String cachedVisibleGlobalVariablesResourceFirstURISegments;

	/**
	 * A flag whether we are inside an Eclipse full build. Always false for non-Eclipse scoping.
	 */
	private static boolean insideFullBuildCycle;

	/**
	 * Can be called to signify the start of a full build cycle. Must be done from the Xtext builder, which cannot be a
	 * dependency of this scope provider, thus this is exported as an API for the .ui package to be used.
	 */
	public static void startFullBuildCycle() {
		insideFullBuildCycle = true;

		// Make sure the cache is cleared in this case, so we don't reuse stuff from older builds
		cachedVisibleGlobalVariablesCurrentModel = null;
		cachedVisibleGlobalVariablesResourceFirstURISegments = null;
	}

	/**
	 * See {@link #startFullBuildCycle()}, just in reverse.
	 */
	public static void endFullBuildCycle() {
		insideFullBuildCycle = false;
	}

	private IScope addVisibleGlobalConstantsAndVariables(IScope aParentScope, EObject aStatement) {
		Model tempRootModel = IntegrityDSLUtil.findUpstreamContainer(Model.class, aStatement);
		URI tempRootModelUri = tempRootModel.eResource().getURI();
		String tempRootModelResourceFirstURISegments = tempRootModelUri
				.trimSegments(tempRootModelUri.segmentCount() - 2).toString();

		boolean tempGlobalCacheMiss = true;
		boolean tempImportCacheMiss = true;
		if (insideFullBuildCycle) {
			// If we are inside a full build cycle, we fully rely on the cache for all global stuff. Therefore a cache
			// miss is only assumed if we switch to a different Eclipse project (= first segments of URI).
			tempGlobalCacheMiss = (!tempRootModelResourceFirstURISegments
					.equals(cachedVisibleGlobalVariablesResourceFirstURISegments));

			// But for the locally imported stuff, the cache miss is when the current document changes
			tempImportCacheMiss = tempGlobalCacheMiss
					| (!tempRootModel.toString().equals(cachedVisibleGlobalVariablesCurrentModel));
		} else {
			tempGlobalCacheMiss = (!tempRootModel.toString().equals(cachedVisibleGlobalVariablesCurrentModel));
			tempImportCacheMiss = tempGlobalCacheMiss;
		}

		Map<String, List<IEObjectDescription>> tempEntitiesPerPackage;
		List<IEObjectDescription> tempGlobalEntities;

		if (tempGlobalCacheMiss) {
			// if (insideFullBuildCycle) {
			// System.out.println("Full Build scoping cache miss: " + tempRootModelResourceFirstURISegments + " vs "
			// + cachedVisibleGlobalVariablesResourceFirstURISegments);
			// } else {
			// System.out.println("Scoping cache miss!");
			// }

			Map<String, List<IEObjectDescription>> tempNewCacheMap = new HashMap<String, List<IEObjectDescription>>();
			List<IEObjectDescription> tempNewCacheList = new ArrayList<IEObjectDescription>();
			IScope tempVisibleVariables = super.getScope(aStatement, DslPackage.Literals.VARIABLE_DEFINITION__NAME);
			IScope tempVisibleConstants = super.getScope(aStatement, DslPackage.Literals.CONSTANT_DEFINITION__NAME);

			Iterator<IEObjectDescription> tempIterator = Iterators.concat(
					tempVisibleVariables.getAllElements().iterator(), tempVisibleConstants.getAllElements().iterator());
			while (tempIterator.hasNext()) {
				IEObjectDescription tempEntityDescription = tempIterator.next();

				EObject tempEntity = tempEntityDescription.getEObjectOrProxy();
				if (tempEntity.eIsProxy()) {
					tempEntity = EcoreUtil.resolve(tempEntity, aStatement);
				}
				String tempPackageName = IntegrityDSLUtil.findUpstreamContainer(PackageDefinition.class, tempEntity)
						.getName();
				String tempSimpleEntityName = tempEntityDescription.getQualifiedName().getLastSegment();

				boolean tempOriginalIsFullyQualified = (tempEntityDescription.getQualifiedName()
						.getSegmentCount() == CharMatcher.is('.').countIn(tempPackageName) - 1);

				IEObjectDescription tempNewEntry;
				if (tempOriginalIsFullyQualified) {
					tempNewEntry = tempEntityDescription;
				} else {
					tempNewEntry = EObjectDescription.create(
							qualifiedNameConverter.toQualifiedName(tempPackageName + "." + tempSimpleEntityName),
							tempEntity);
				}

				List<IEObjectDescription> tempPackageCacheEntries = tempNewCacheMap.get(tempPackageName);
				if (tempPackageCacheEntries == null) {
					tempPackageCacheEntries = new ArrayList<IEObjectDescription>();
					tempNewCacheMap.put(tempPackageName, tempPackageCacheEntries);
				}
				tempPackageCacheEntries.add(tempNewEntry);
				tempNewCacheList.add(tempNewEntry);
			}

			tempEntitiesPerPackage = tempNewCacheMap;
			tempGlobalEntities = tempNewCacheList;
			cachedVisibleGlobalVariables = tempGlobalEntities;
			cachedVisibleGlobalVariablesMap = tempEntitiesPerPackage;
			cachedVisibleGlobalVariablesResourceFirstURISegments = tempRootModelResourceFirstURISegments;
			cachedVisibleGlobalVariablesCurrentModel = tempRootModel.toString();
		} else {
			tempEntitiesPerPackage = cachedVisibleGlobalVariablesMap;
			tempGlobalEntities = cachedVisibleGlobalVariables;
		}

		List<IEObjectDescription> tempScopeAdditionalList;

		if (tempImportCacheMiss) {
			// System.out
			// .println("Import cache miss: " + tempRootModel + " vs " + cachedVisibleGlobalVariablesCurrentModel);

			// Now use the cache to build a scope of all visible global constants and variables, taking imports into
			// account
			List<String> tempImports = new ArrayList<>();
			for (Statement tempStatement : tempRootModel.getStatements()) {
				if (tempStatement instanceof Import) {
					String tempImport = ((Import) tempStatement).getImportedNamespace();
					if (tempImport.endsWith(".*")) {
						tempImport = tempImport.substring(0, tempImport.length() - 2);
					}
					tempImports.add(tempImport);
				}
			}

			tempScopeAdditionalList = new ArrayList<IEObjectDescription>();
			for (Entry<String, List<IEObjectDescription>> tempEntry : cachedVisibleGlobalVariablesMap.entrySet()) {
				String tempPackageName = tempEntry.getKey();

				for (String tempImport : tempImports) {
					if (tempPackageName.equals(tempImport)
							|| (tempPackageName.length() > tempImport.length() && tempPackageName.startsWith(tempImport)
									&& tempPackageName.charAt(tempImport.length()) == '.')) {
						int tempSegmentsToSkip = CharMatcher.is('.').countIn(tempImport) + 1;
						for (IEObjectDescription tempDescription : tempEntry.getValue()) {
							tempScopeAdditionalList.add(
									EObjectDescription.create(tempDescription.getName().skipFirst(tempSegmentsToSkip),
											tempDescription.getEObjectOrProxy()));
							// System.out.println("--> added '" +
							// tempDescription.getName().skipFirst(tempSegmentsToSkip)
							// + "' to scope due to import '" + tempImport + "'");
						}
					}
				}
			}
			cachedImportedGlobalVariables = tempScopeAdditionalList;
			cachedVisibleGlobalVariablesCurrentModel = tempRootModel.toString();
		} else {
			tempScopeAdditionalList = cachedImportedGlobalVariables;
		}

		// Finally, filter out private variables not in the current package
		return filterPrivateElements(
				new SimpleScope(aParentScope, Iterables.concat(tempGlobalEntities, tempScopeAdditionalList)),
				aStatement);
	}

	private IScope filterPrivateElements(IScope aScope, final EObject aStatement) {
		PackageDefinition tempCurrentPackage = IntegrityDSLUtil.findUpstreamContainer(PackageDefinition.class,
				aStatement);
		final String tempCurrentPackageName = tempCurrentPackage == null ? "" : tempCurrentPackage.getName();

		return new FilteringScope(aScope, new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply(IEObjectDescription anInput) {
				EObject tempObjectOrProxy = anInput.getEObjectOrProxy();
				EObject tempObject;
				if (tempObjectOrProxy.eIsProxy()) {
					tempObject = EcoreUtil.resolve(tempObjectOrProxy, aStatement);
				} else {
					tempObject = tempObjectOrProxy;
				}
				if ((tempObject instanceof VariableEntity) || (tempObject instanceof ConstantEntity)) {
					tempObject = tempObject.eContainer();
				}

				if (IntegrityDSLUtil.isPrivate(tempObject)) {
					PackageDefinition tempPackage = IntegrityDSLUtil.findUpstreamContainer(PackageDefinition.class,
							tempObject);
					if (tempPackage != null) {
						return tempCurrentPackageName.equals(tempPackage.getName());
					} else {
						return true;
					}
				}

				return true;
			}

		});
	}

	private IScope determineVariableScope(EObject aStatement, SuiteDefinition aSuite) {
		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();

		EObject tempStop = findSuiteStatementFromSubObject(aStatement);

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof VariableDefinition) {
				VariableEntity tempEntity = ((VariableDefinition) tempStatement).getName();
				if (tempEntity != null) {
					tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
				}
			} else if (tempStatement instanceof ConstantDefinition) {
				ConstantEntity tempEntity = ((ConstantDefinition) tempStatement).getName();
				if (tempEntity != null) {
					tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
				}
			} else if (tempStatement == tempStop) {
				break;
			}
		}
		IScope tempScope = new SimpleScope(tempList);

		// Now add global constants and variables.
		tempScope = addVisibleGlobalConstantsAndVariables(tempScope, aStatement);

		// And add suite parameters, which are handled like variables as well.
		ArrayList<IEObjectDescription> tempSuiteParameterAndReturnList = new ArrayList<IEObjectDescription>();
		for (VariableEntity tempSuiteParam : ParameterUtil.getVariableEntitiesForSuiteParameters(aSuite)) {
			tempSuiteParameterAndReturnList.add(EObjectDescription.create(tempSuiteParam.getName(), tempSuiteParam));
		}

		// Just like suite return variables
		for (SuiteReturnDefinition tempSuiteReturn : aSuite.getReturn()) {
			tempSuiteParameterAndReturnList
					.add(EObjectDescription.create(tempSuiteReturn.getName().getName(), tempSuiteReturn.getName()));
		}

		return new SimpleScope(tempScope, tempSuiteParameterAndReturnList);
	}

	private IScope determineVariableScope(PackageDefinition aPackageDef) {
		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
		IScope tempScope = new SimpleScope(tempList);

		// Add constants/variables defined in current package
		for (PackageStatement tempStatement : aPackageDef.getStatements()) {
			if (tempStatement instanceof VariableDefinition) {
				VariableEntity tempEntity = ((VariableDefinition) tempStatement).getName();
				if (tempEntity != null) {
					tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
				}
			} else if (tempStatement instanceof ConstantDefinition) {
				ConstantEntity tempEntity = ((ConstantDefinition) tempStatement).getName();
				if (tempEntity != null) {
					tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
				}
			}
		}

		// Add global constants and variables.
		tempScope = addVisibleGlobalConstantsAndVariables(tempScope, aPackageDef);

		return tempScope;
	}

	private EObject findSuiteStatementFromSubObject(EObject aSubObject) {
		EObject tempObject = aSubObject.eContainer();
		EObject tempParent = tempObject.eContainer();

		while (tempParent != null) {
			if (tempParent instanceof SuiteDefinition) {
				return tempObject;
			} else {
				tempObject = tempParent;
				tempParent = tempObject.eContainer();
			}
		}

		return null;
	}

	// This is very useful for debugging scoping problems - it dumps out which declarative methods are actually
	// being tried during the resolve period of a scope. REMOVE COMMENTS WITH CARE! NOT FOR CHECK-INs!
	//
	// @Override
	// public IScope getScope(EObject aContext, EReference aReference) {
	// System.out.println("Scope Request: scope_" + aReference.getEContainingClass().getName() + "_"
	// + aReference.getName() + "(" + aContext.getClass().getName() + ")");
	//
	// return super.getScope(aContext, aReference);
	// }
}
