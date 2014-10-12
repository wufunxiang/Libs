//
// MessagePack for Java
//
// Copyright (C) 2009 - 2013 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.type;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.io.IOException;
import org.msgpack.packer.Packer;

@SuppressWarnings("serial")
class FloatValueImpl extends FloatValue {
    private float value;

    FloatValueImpl(float value) {
        this.value = value;
    }

    
    public float getFloat() {
        return value;
    }

    
    public double getDouble() {
        return (double) value;
    }

    
    public byte byteValue() {
        return (byte) value;
    }

    
    public short shortValue() {
        return (short) value;
    }

    
    public int intValue() {
        return (int) value;
    }

    
    public long longValue() {
        return (long) value;
    }

    
    public BigInteger bigIntegerValue() {
        return new BigDecimal((double) value).toBigInteger();
    }

    
    public float floatValue() {
        return value;
    }

    
    public double doubleValue() {
        return (double) value;
    }

    
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value)) {
            return false;
        }
        Value v = (Value) o;
        if (!v.isFloatValue()) {
            return false;
        }

        return (double) value == v.asFloatValue().getDouble();
    }

    
    public void writeTo(Packer pk) throws IOException {
        pk.write(value);
    }

    // TODO compareTo

    
    public int hashCode() {
        return Float.floatToIntBits(value);
    }

    
    public String toString() {
        return Float.toString(value);
    }

    
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(Float.toString(value));
    }
}
