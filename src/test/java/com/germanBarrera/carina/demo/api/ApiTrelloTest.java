package com.germanBarrera.carina.demo.api;

import com.germanBarrera.utils.api.GetCardById;
import com.germanBarrera.utils.api.GetCardsListOnBoard_Id;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class ApiTrelloTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "germanBarrera")
    public void getBoardsList() throws Exception {
        GetCardsListOnBoard_Id getCardList = new GetCardsListOnBoard_Id();
        getCardList.setProperties("api/user.properties");
        getCardList.addParameter("key",getCardList.getProperties().getProperty("key"));
        getCardList.addParameter("token",getCardList.getProperties().getProperty("token"));
        getCardList.callAPIExpectSuccess();
//        getCardList.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "germanBarrera")
    public void getCardById(){
        GetCardById getCardById = new GetCardById();
        getCardById.setProperties("api/user.properties");
        getCardById.addParameter("id",getCardById.getProperties().getProperty("card_id"));
        getCardById.addParameter("key",getCardById.getProperties().getProperty("key"));
        getCardById.addParameter("token",getCardById.getProperties().getProperty("token"));
        getCardById.callAPIExpectSuccess();
    }
}
