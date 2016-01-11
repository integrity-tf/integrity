/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Call#getMultiplier <em>Multiplier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Call#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Call#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Call#getResults <em>Results</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Call#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends SuiteStatementWithResult
{
  /**
   * Returns the value of the '<em><b>Multiplier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplier</em>' containment reference.
   * @see #setMultiplier(ExecutionMultiplier)
   * @see de.gebit.integrity.dsl.DslPackage#getCall_Multiplier()
   * @model containment="true"
   * @generated
   */
  ExecutionMultiplier getMultiplier();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Call#getMultiplier <em>Multiplier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplier</em>' containment reference.
   * @see #getMultiplier()
   * @generated
   */
  void setMultiplier(ExecutionMultiplier value);

  /**
   * Returns the value of the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' reference.
   * @see #setDefinition(CallDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getCall_Definition()
   * @model
   * @generated
   */
  CallDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Call#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(CallDefinition value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getCall_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Results</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.NamedCallResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getCall_Results()
   * @model containment="true"
   * @generated
   */
  EList<NamedCallResult> getResults();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(VariableVariable)
   * @see de.gebit.integrity.dsl.DslPackage#getCall_Result()
   * @model containment="true"
   * @generated
   */
  VariableVariable getResult();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Call#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(VariableVariable value);

} // Call
