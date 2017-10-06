package com.shay.test.countries.shaycountriestest;

import com.shay.test.countries.shaycountriestest.setup.ISetupInteractor;
import com.shay.test.countries.shaycountriestest.setup.SetupInteractorImpl;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.junit.Test;

/**
 * Created by Sahar on 06/10/2017.
 */

public class SetupTest extends TestCase
{
    @Test
    public void testLoad()
    {
        ISetupInteractor test = new SetupInteractorImpl();
        try
        {
            JSONArray data = new JSONArray();
            test.onSuccess(data);
        } catch (Exception e)
        {

        }
        assertEquals(0, test.getCountryData().size());
    }
}
