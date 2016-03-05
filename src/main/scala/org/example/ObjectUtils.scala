package org.example

import java.lang.AbstractStringBuilder

object ObjectUtils {

  def defaultIfNull[T](value:T, defaultValue:T):T = {
    if(value != null) value else defaultValue
  }

  def firstNonNull[T](values:T*) = {
    values.find { value => value != null }
  }

  def identityToString(value:Any): String = {
    ""
  }

  def identityToString(appendable:Appendable, value:Any): String = {
    if (value == null) throw new NullPointerException
    appendable.append(value.getClass().getName)
      .append('@')
      .append(Integer.toHexString(System.identityHashCode(value)))
      .toString()
  }

  def identityToString(strBuilder:StringBuilder, value:Any): String = {
    if(value == null) throw new NullPointerException
    strBuilder.append(value.getClass().getName)
      .append('@')
      .append(Integer.toHexString(System.identityHashCode(value)))
      .toString()
  }

  def identityToString(strBuffer:StringBuffer, value:Any): String = {
    if(value == null) throw new NullPointerException
    strBuffer.append(value.getClass().getName)
      .append('@')
      .append(Integer.toHexString(System.identityHashCode(value)))
      .toString()
  }


}