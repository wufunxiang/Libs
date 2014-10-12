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

import java.io.IOException;
import org.msgpack.packer.Packer;

public class NilValue extends AbstractValue {
    private NilValue() {
    }

    private static NilValue instance = new NilValue();

    static NilValue getInstance() {
        return instance;
    }

    
    public ValueType getType() {
        return ValueType.NIL;
    }

    
    public boolean isNilValue() {
        return true;
    }

    
    public NilValue asNilValue() {
        return this;
    }

    
    public String toString() {
        return "null";
    }

    
    public StringBuilder toString(StringBuilder sb) {
        return sb.append("null");
    }

    
    public void writeTo(Packer pk) throws IOException {
        pk.writeNil();
    }

    
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value)) {
            return false;
        }
        return ((Value) o).isNilValue();
    }

    
    public int hashCode() {
        return 0;
    }
}
