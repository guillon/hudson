/**
 * The MIT License
 *
 * Copyright (c) 2010-2011 Sonatype, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.hudsonci.inject.injecto;

import org.hudsonci.inject.TestSupport;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.*;

/**
 * Tests for {@link Injectable} types.
 */
public class InjectableTest
    extends TestSupport
{
    @Test
    public void testInjectoAware() {
        InjectableThing thing = new InjectableThing();
        assertNotNull(thing);
        assertNotNull(thing.component);
    }

    @Named
    public static class MyComponent
    {
        public MyComponent() {
            System.out.println("Created component");
        }
    }

    public static class InjectableThing
        implements Injectable
    {
        MyComponent component;

        @Inject
        public void setComponent(MyComponent component) {
            System.out.println("Installed component: " + component);
            this.component = component;
        }
    }
}