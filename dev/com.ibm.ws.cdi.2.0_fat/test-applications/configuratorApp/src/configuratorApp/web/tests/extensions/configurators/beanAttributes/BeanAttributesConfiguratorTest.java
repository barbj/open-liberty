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
package configuratorApp.web.tests.extensions.configurators.beanAttributes;

import static org.junit.Assert.assertTrue;

import javax.enterprise.inject.spi.Bean;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import configuratorApp.web.ConfiguratorTestBase;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/beanAttributesConfiguratorTest")
public class BeanAttributesConfiguratorTest extends ConfiguratorTestBase {

    @Test
    public void sniffBeanAttributesConfigurator() {
        Bean<Square> bean = getBean(Square.class, Quadrilateral.QuadrilateralLiteral.INSTANCE);

        assertTrue(bean.getQualifiers().contains(Quadrilateral.QuadrilateralLiteral.INSTANCE));
        assertTrue(bean.getTypes().contains(Shape.class));
    }
}
