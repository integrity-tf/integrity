/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.DslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arbitrary Parameter Or Result Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl#getStringIdentifier <em>String Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArbitraryParameterOrResultNameImpl extends ResultNameImpl implements ArbitraryParameterOrResultName
{
  /**
   * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifier()
   * @generated
   * @ordered
   */
  protected static final String IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifier()
   * @generated
   * @ordered
   */
  protected String identifier = IDENTIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getStringIdentifier() <em>String Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringIdentifier()
   * @generated
   * @ordered
   */
  protected static final String STRING_IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStringIdentifier() <em>String Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringIdentifier()
   * @generated
   * @ordered
   */
  protected String stringIdentifier = STRING_IDENTIFIER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArbitraryParameterOrResultNameImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.ARBITRARY_PARAMETER_OR_RESULT_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIdentifier()
  {
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentifier(String newIdentifier)
  {
    String oldIdentifier = identifier;
    identifier = newIdentifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER, oldIdentifier, identifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringIdentifier()
  {
    return stringIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringIdentifier(String newStringIdentifier)
  {
    String oldStringIdentifier = stringIdentifier;
    stringIdentifier = newStringIdentifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER, oldStringIdentifier, stringIdentifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER:
        return getIdentifier();
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER:
        return getStringIdentifier();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER:
        setIdentifier((String)newValue);
        return;
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER:
        setStringIdentifier((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER:
        setIdentifier(IDENTIFIER_EDEFAULT);
        return;
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER:
        setStringIdentifier(STRING_IDENTIFIER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER:
        return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER:
        return STRING_IDENTIFIER_EDEFAULT == null ? stringIdentifier != null : !STRING_IDENTIFIER_EDEFAULT.equals(stringIdentifier);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (identifier: ");
    result.append(identifier);
    result.append(", stringIdentifier: ");
    result.append(stringIdentifier);
    result.append(')');
    return result.toString();
  }

} //ArbitraryParameterOrResultNameImpl
