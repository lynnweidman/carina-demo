package com.zebrunner.carina.demo;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class APIRegresTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testGetUsers() {

        GetRegresMethod getRegresMethod = new GetRegresMethod();
        getRegresMethod.callAPIExpectSuccess();
        getRegresMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getRegresMethod.validateResponseAgainstSchema("api/users/_get/rs_regres.schema");

    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");

        //Gets data from .properties
        PostRegresMethod api = new PostRegresMethod();
        api.setProperties("api/users/regres.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Lynn Weidman")
    public void testPatchUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");

        //Gets data from .properties
        PatchRegresMethod api = new PatchRegresMethod();
        api.setProperties("api/users/patch_regres.properties");

        // Get data from inline code
       /* Properties properties = new Properties();
        properties.put("name", "Beth Dudley");
        properties.put("job", "Manager");
        api.setProperties(properties);*/

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }
}
