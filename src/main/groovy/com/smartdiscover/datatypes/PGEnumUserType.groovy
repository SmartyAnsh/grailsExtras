package com.smartdiscover.datatypes

import org.hibernate.HibernateException
import org.hibernate.engine.spi.SessionImplementor
import org.hibernate.usertype.ParameterizedType
import org.hibernate.usertype.UserType

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

public class PGEnumUserType implements UserType, ParameterizedType {
    private static final SQL_TYPES = [Types.VARCHAR] as int[]
    private Class enumClass;

    @Override
    public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty("enumClassName")
        try {
            enumClass = (Class) Class.forName(enumClassName)
        }
        catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe)
        }
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException { return cached }

    @Override
    public Object deepCopy(Object value) throws HibernateException { return value }

    @Override
    public Serializable disassemble(Object value) throws HibernateException { return value }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException { return x.equals(y) }

    @Override
    public int hashCode(Object x) throws HibernateException { return x.hashCode() }

    @Override
    public boolean isMutable() { return false }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        def result = rs.getObject(names[0]);
        if (result) {
            return Enum.valueOf ( enumClass, ( String ) result )
        } else {
            return null
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value) {
            st.setObject(index, ((Enum) value), 1111);
        } else {
            st.setNull(index, Types.VARCHAR)
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException { return original }

    @Override
    public Class returnedClass() {
        return enumClass
    }

    @Override
    public int[] sqlTypes() { return SQL_TYPES }
}