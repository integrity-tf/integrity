/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getHeaders <em>Headers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTableTest()
 * @model
 * @generated
 */
public interface TableTest extends SuiteStatementWithResult
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
   * @see #setDefinition(TestDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_Definition()
   * @model
   * @generated
   */
  TestDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TableTest#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(TestDefinition value);

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
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ParameterTableHeader}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Headers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Headers</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_Headers()
   * @model containment="true"
   * @generated
   */
  EList<ParameterTableHeader> getHeaders();

  /**
   * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.TableTestRow}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rows</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_Rows()
   * @model containment="true"
   * @generated
   */
  EList<TableTestRow> getRows();

} // TableTest
