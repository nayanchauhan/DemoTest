package com.selenium.realpage.common.dataProvider;

import com.google.gson.Gson;
import com.selenium.realpage.dataTypes.TestData;
import com.selenium.realpage.common.manager.ReaderManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    private final String dataFilePath = ReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "TestData.json";
    private List<TestData> testList;
    private String filePath;
    
    
    public JsonReader() {
        this.testList = getTestData();
    }

    private List<TestData> getTestData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(dataFilePath));
            TestData[] tests = gson.fromJson(bufferReader, TestData[].class);
            return Arrays.asList(tests);
        }catch(FileNotFoundException e){
            throw new RuntimeException("Json file not found at path : " + dataFilePath );
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final TestData getDataTestById(String testId){
        for(TestData testdata : testList) {
            if(testdata.testId.equalsIgnoreCase(testId)) return testdata;
        }
        return null;
    }

    public final void PathFile(String filePath){
        this.filePath = dataFilePath + filePath;
    }


}
