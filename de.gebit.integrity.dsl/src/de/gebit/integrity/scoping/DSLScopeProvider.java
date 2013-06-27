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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.PackageStatement;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.Statement;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParamAnnotationTypeTriplet;
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

			if (tempForkDef.getForkerClass() != null
					&& (tempForkDef.getForkerClass().getType() instanceof JvmGenericType)) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<ParamAnnotationTypeTriplet> tempParamList = IntegrityDSLUtil
						.getAllParamNamesFromForker((JvmGenericType) tempForkDef.getForkerClass().getType());

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
							if (FixtureMethod.class.getName().equals(tempAnnotation.getAnnotation().getQualifiedName())) {
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
			for (VariableOrConstantEntity tempParam : tempSuiteDef.getParameters()) {
				tempList.add(EObjectDescription.create(tempParam.getName(), tempParam));
			}

			return new SimpleScope(tempList);
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
		}

		ParameterName tempParamName = aParameter.getName();

		if (tempParamName instanceof FixedParameterName) {
			JvmAnnotationReference tempAnnotationRef = ((FixedParameterName) tempParamName).getAnnotation();

			if (tempMethodRef != null && tempAnnotationRef != null) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<JvmEnumerationLiteral> tempLiteralList = IntegrityDSLUtil
						.getAllEnumLiteralsFromFixtureMethodParam(tempMethodRef, tempAnnotationRef);
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
	 * Limit enum values in test results to actually existent enumeration literals.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(Test aTest, EReference aRef) {
		MethodReference tempMethodRef = aTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<JvmEnumerationLiteral> tempLiteralList = IntegrityDSLUtil
					.getAllEnumLiteralsFromJvmTypeReference(tempMethodRef.getMethod().getReturnType());
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
	public IScope scope_Variable_name(Call aCall, EReference aRef) {
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
	 * Filters out variables defined as suite parameters or local variables in other suites.
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

	@Override
	public IScope getScope(EObject aContext, EReference aReference) {
		System.out.println("Scope Request: scope_" + aReference.getEContainingClass().getName() + "_"
				+ aReference.getName() + "(" + aContext.getClass().getName() + ")");

		return super.getScope(aContext, aReference);
	}

	/**
	 * A small cache for visible global variables. Determining these is rather expensive, thus they're cached as long as
	 * only one model (file) is being scoped.
	 */
	private ArrayList<IEObjectDescription> cachedVisibleGlobalVariables = new ArrayList<IEObjectDescription>();

	/**
	 * This is used to invalidate the {@link #cachedVisibleGlobalVariables}, as soon as scoping is done for a different
	 * model.
	 */
	private Model cachedVisibleGlobalVariablesResource;

	private ArrayList<IEObjectDescription> determineVisibleGlobalVariables(EObject aStatement) {
		Model tempRootModel = IntegrityDSLUtil.findUpstreamContainer(Model.class, aStatement);

		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();

		if (cachedVisibleGlobalVariablesResource != tempRootModel) {
			// Cache miss! Now we need to search all package vars/constants outside of the current model.

			ArrayList<IEObjectDescription> tempCacheableList = new ArrayList<IEObjectDescription>();
			IScope tempVariableScope = super.getScope(aStatement, DslPackage.Literals.VARIABLE_DEFINITION__NAME);
			IScope tempConstantScope = super.getScope(aStatement, DslPackage.Literals.CONSTANT_DEFINITION__NAME);
			for (IScope tempScope : new IScope[] { tempVariableScope, tempConstantScope }) {
				for (IEObjectDescription tempVariableDefDescription : tempScope.getAllElements()) {
					EObject tempVariableDef = tempVariableDefDescription.getEObjectOrProxy();
					if (tempVariableDef.eIsProxy()) {
						tempVariableDef = EcoreUtil.resolve(tempVariableDef, aStatement);
					}
					if (tempVariableDef.eContainer() != null) {
						EObject tempPackageDef = tempVariableDef.eContainer().eContainer();
						if (tempPackageDef instanceof PackageDefinition) {
							Model tempPackageHostModel = IntegrityDSLUtil.findUpstreamContainer(Model.class,
									tempPackageDef);

							// Don't add definitions from current file here; they aren't cacheable and will get invalid
							if (tempPackageHostModel != tempRootModel) {
								tempCacheableList.add(tempVariableDefDescription);
							}
						}
					}
				}
			}

			cachedVisibleGlobalVariables = tempCacheableList;
			cachedVisibleGlobalVariablesResource = tempRootModel;
		}

		tempList.addAll(cachedVisibleGlobalVariables);

		// Add definitions from current file
		for (Statement tempStatement : tempRootModel.getStatements()) {
			if (tempStatement instanceof PackageDefinition) {
				for (PackageStatement tempPackageStatement : ((PackageDefinition) tempStatement).getStatements()) {
					if (tempPackageStatement instanceof VariableDefinition) {
						VariableEntity tempEntity = ((VariableDefinition) tempPackageStatement).getName();
						tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
					} else if (tempPackageStatement instanceof ConstantDefinition) {
						ConstantEntity tempEntity = ((ConstantDefinition) tempPackageStatement).getName();
						tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
					}
				}
			}
		}

		return tempList;
	}

	private IScope determineVariableScope(EObject aStatement, SuiteDefinition aSuite) {
		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();

		EObject tempStop = findSuiteStatementFromSubObject(aStatement);

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof VariableDefinition) {
				VariableEntity tempEntity = ((VariableDefinition) tempStatement).getName();
				tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
			} else if (tempStatement instanceof ConstantDefinition) {
				ConstantEntity tempEntity = ((ConstantDefinition) tempStatement).getName();
				tempList.add(EObjectDescription.create(tempEntity.getName(), tempEntity));
			} else if (tempStatement == tempStop) {
				break;
			}
		}

		// Now add global constants and variables.
		tempList.addAll(determineVisibleGlobalVariables(aStatement));

		// And add suite parameters, which are handled like variables as well.
		for (VariableEntity tempSuiteParam : aSuite.getParameters()) {
			tempList.add(EObjectDescription.create(tempSuiteParam.getName(), tempSuiteParam));
		}

		return new SimpleScope(tempList);
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
}
