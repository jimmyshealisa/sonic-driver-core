/*
 *  Copyright (C) [SonicCloudOrg] Sonic Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.cloud.sonic.core.ios.service;

import org.cloud.sonic.core.ios.RespHandler;
import org.cloud.sonic.core.ios.models.BaseResp;
import org.cloud.sonic.core.ios.models.ErrorMsg;
import org.cloud.sonic.core.ios.models.PasteboardType;
import org.cloud.sonic.core.ios.models.TouchActions;
import org.cloud.sonic.core.ios.service.impl.WdaClientImpl;
import org.cloud.sonic.core.tool.SonicRespException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class WdaClientTest {
    static WdaClient wdaClient;
    private static final String ERROR_MSG = "err message";

    @BeforeClass
    public static void before() throws Exception {
        wdaClient = new WdaClientImpl();
        wdaClient.setSessionId("test");
        wdaClient.setRemoteUrl("http://localhost:8100");
        RespHandler respHandler = Mockito.mock(RespHandler.class);
        BaseResp b = new BaseResp();
        b.setErr(new ErrorMsg("testErr", ERROR_MSG, "traceback"));
        Assert.assertNull(b.getSessionId());
        Mockito.when(respHandler.getResp(Mockito.any())).thenReturn(b);
        Mockito.when(respHandler.getResp(Mockito.any(), Mockito.anyInt())).thenReturn(b);
        Field respField = wdaClient.getClass().getDeclaredField("respHandler");
        respField.setAccessible(true);
        respField.set(wdaClient, respHandler);
    }

    @Test
    public void testLocked() {
        Boolean hasThrow = false;
        try {
            wdaClient.isLocked();
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testLock() {
        Boolean hasThrow = false;
        try {
            wdaClient.lock();
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testUnLock() {
        Boolean hasThrow = false;
        try {
            wdaClient.unlock();
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testPerformTouchAction() {
        Boolean hasThrow = false;
        try {
            wdaClient.performTouchAction(new TouchActions());
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testSendKeys() {
        Boolean hasThrow = false;
        try {
            wdaClient.sendKeys("test", 1);
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testSetPasteboard() {
        Boolean hasThrow = false;
        try {
            wdaClient.setPasteboard(PasteboardType.PLAIN_TEXT.getType(),"text");
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testGetPasteboard() {
        Boolean hasThrow = false;
        try {
            wdaClient.getPasteboard(PasteboardType.PLAIN_TEXT.getType());
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testPageSource() {
        Boolean hasThrow = false;
        try {
            wdaClient.pageSource();
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testPressButton() {
        Boolean hasThrow = false;
        try {
            wdaClient.pressButton("home");
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testSiriCommand() {
        Boolean hasThrow = false;
        try {
            wdaClient.sendSiriCommand("home");
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testAppActivate() {
        Boolean hasThrow = false;
        try {
            wdaClient.appActivate("developer.apple.wwdc-Release");
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testAppTerminate() {
        Boolean hasThrow = false;
        try {
            wdaClient.appTerminate("developer.apple.wwdc-Release");
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }

    @Test
    public void testAppAuthReset() {
        Boolean hasThrow = false;
        try {
            wdaClient.appAuthReset(6);
        } catch (Throwable e) {
            hasThrow = true;
            Assert.assertEquals(SonicRespException.class, e.getClass());
            Assert.assertEquals(e.getMessage(), ERROR_MSG);
        }
        Assert.assertTrue(hasThrow);
    }
}
