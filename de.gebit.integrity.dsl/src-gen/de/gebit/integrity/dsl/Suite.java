/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Suite#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Suite#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Suite#getFork <em>Fork</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getSuite()
 * @model
 * @generated
 */
public interface Suite extends Statement, SuiteStatementWithResult
{
  /**
   * Returns the value of the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' reference.
   * @see #setDefinition(SuiteDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getSuite_Definition()
   * @model
   * @generated
   */
  SuiteDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Suite#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(SuiteDefinition value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.SuiteParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getSuite_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<SuiteParameter> getParameters();

  /**
   * Returns the value of the '<em><b>Fork</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fork</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fork</em>' reference.
   * @see #setFork(ForkDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getSuite_Fork()
   * @model
   * @generated
   */
  ForkDefinition getFork();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Suite#getFork <em>Fork</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fork</em>' reference.
   * @see #getFork()
   * @generated
   */
  void setFork(ForkDefinition value);

} // Suite
