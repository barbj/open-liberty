/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package configuratorApp.web.tests.extensions.configurators.observerMethod;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import configuratorApp.web.ConfiguratorTestBase;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/observerMethodConfiguratorTest")
public class ObserverMethodConfiguratorTest extends ConfiguratorTestBase {

    @Inject
    BeanManager bm;

    @Test
    public void sniffObserverMethodConfigurator() {
        Set<ObserverMethod<? super Triangle>> observers = bm.resolveObserverMethods(new Triangle(), Any.Literal.INSTANCE);
        assertEquals(observers.iterator().next().getPriority(), ObserverMethod.DEFAULT_PRIORITY + 1);
    }
}