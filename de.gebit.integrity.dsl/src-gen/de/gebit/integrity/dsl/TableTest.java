/**
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
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getParameterHeaders <em>Parameter Headers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getResultHeaders <em>Result Headers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getDefaultResultColumn <em>Default Result Column</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TableTest#getRows <em>Rows</em>}</li>
 * </ul>
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
   * Returns the value of the '<em><b>Parameter Headers</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ParameterTableHeader}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Headers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Headers</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_ParameterHeaders()
   * @model containment="true"
   * @generated
   */
  EList<ParameterTableHeader> getParameterHeaders();

  /**
   * Returns the value of the '<em><b>Result Headers</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ResultTableHeader}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Headers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Headers</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_ResultHeaders()
   * @model containment="true"
   * @generated
   */
  EList<ResultTableHeader> getResultHeaders();

  /**
   * Returns the value of the '<em><b>Default Result Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Result Column</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Result Column</em>' attribute.
   * @see #setDefaultResultColumn(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTableTest_DefaultResultColumn()
   * @model
   * @generated
   */
  String getDefaultResultColumn();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TableTest#getDefaultResultColumn <em>Default Result Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Result Column</em>' attribute.
   * @see #getDefaultResultColumn()
   * @generated
   */
  void setDefaultResultColumn(String value);

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
