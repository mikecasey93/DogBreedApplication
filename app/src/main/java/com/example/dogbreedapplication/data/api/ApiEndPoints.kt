package com.example.dogbreedapplication.data.api

import com.example.dogbreedapplication.data.model.dog_breeds.DogBreedModel
import retrofit2.http.GET

interface ApiEndPoints {

    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getDogBreeds(): DogBreedModel
}