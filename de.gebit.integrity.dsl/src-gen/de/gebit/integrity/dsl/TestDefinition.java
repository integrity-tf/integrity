/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TestDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TestDefinition#getFixtureMethod <em>Fixture Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTestDefinition()
 * @model
 * @generated
 */
public interface TestDefinition extends PackageStatement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTestDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TestDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fixture Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fixture Method</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fixture Method</em>' containment reference.
   * @see #setFixtureMethod(MethodReference)
   * @see de.gebit.integrity.dsl.DslPackage#getTestDefinition_FixtureMethod()
   * @model containment="true"
   * @generated
   */
  MethodReference getFixtureMethod();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TestDefinition#getFixtureMethod <em>Fixture Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fixture Method</em>' containment reference.
   * @see #getFixtureMethod()
   * @generated
   */
  void setFixtureMethod(MethodReference value);

} // TestDefinition
