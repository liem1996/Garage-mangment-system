package com.example.garageclient;

import android.content.Context;

import java.util.Map;

public class Model {

    public static final Model instance = new Model();

    public interface addVehicleListener {
        void onComplete(int code);
    }
/*
    public void addOffer(Offer offer, ModelOffers.addOfferListener addOffer) {
        tokensrefresh.retroServer();

        Map<String, Object> map = offer.toJson();
        String tockenacsses = MyApplication.getContext()
                .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                .getString("tokenAcsses", "");

        Call<Offer> call = tokensrefresh.retrofitInterface.executenewOffer(map, "Bearer " + tockenacsses);

        call.enqueue(new Callback<Offer>() {
            @Override
            public void onResponse(Call<Offer> call, Response<Offer> response) {
                if (response.code() == 200) {
                    addOffer.onComplete(200);
                } else if (response.code() == 403) {
                    tokensrefresh.changeAcssesToken();
                    String tockennew = tokensrefresh.gettockenAcsses();
                    Call<Offer> call1 = tokensrefresh.retrofitInterface.executenewOffer(map, "Bearer " + tockennew);
                    call1.enqueue(new Callback<Offer>() {
                        @Override
                        public void onResponse(Call<Offer> call, Response<Offer> response1) {
                            if (response1.code() == 200) {
                                addOffer.onComplete(200);
                            } else {
                                addOffer.onComplete(400);
                            }
                        }

                        @Override
                        public void onFailure(Call<Offer> call, Throwable t) {
                            addOffer.onComplete(400);
                        }
                    });
                } else {
                    addOffer.onComplete(400);
                }
            }

            @Override
            public void onFailure(Call<Offer> call, Throwable t) {
                addOffer.onComplete(400);
            }
        });
    }
*/
}
