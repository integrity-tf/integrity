package de.integrity.values;

import java.lang.reflect.Method;
import java.math.BigInteger;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

public class TestDSLValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "INTEGER")
	public IValueConverter<BigInteger> INTEGER() {
		return new IValueConverter<BigInteger>() {

			@Override
			public BigInteger toValue(String string, INode node)
					throws ValueConverterException {
				return new BigInteger(string);
			}

			@Override
			public String toString(BigInteger value)
					throws ValueConverterException {
				return value.toString();
			}
			
		};
	}
	
	@ValueConverter(rule = "DECIMAL")
	public IValueConverter<BigInteger> DECIMAL() {
		return new IValueConverter<BigInteger>() {

			@Override
			public BigInteger toValue(String string, INode node)
					throws ValueConverterException {
				return new BigInteger(string);
			}

			@Override
			public String toString(BigInteger value)
					throws ValueConverterException {
				return value.toString();
			}
			
		};
	}
	
}
