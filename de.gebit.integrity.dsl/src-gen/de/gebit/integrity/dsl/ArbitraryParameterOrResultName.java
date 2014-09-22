/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arbitrary Parameter Or Result Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getStringIdentifier <em>String Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getArbitraryParameterOrResultName()
 * @model
 * @generated
 */
public interface ArbitraryParameterOrResultName extends ResultName, ParameterName
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' attribute.
   * @see #setIdentifier(String)
   * @see de.gebit.integrity.dsl.DslPackage#getArbitraryParameterOrResultName_Identifier()
   * @model
   * @generated
   */
  String getIdentifier();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getIdentifier <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' attribute.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(String value);

  /**
   * Returns the value of the '<em><b>String Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Identifier</em>' attribute.
   * @see #setStringIdentifier(String)
   * @see de.gebit.integrity.dsl.DslPackage#getArbitraryParameterOrResultName_StringIdentifier()
   * @model
   * @generated
   */
  String getStringIdentifier();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getStringIdentifier <em>String Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Identifier</em>' attribute.
   * @see #getStringIdentifier()
   * @generated
   */
  void setStringIdentifier(String value);

} // ArbitraryParameterOrResultName
