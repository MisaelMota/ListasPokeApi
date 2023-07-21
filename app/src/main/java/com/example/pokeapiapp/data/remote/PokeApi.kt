package com.example.pokeapiapp.data.remote

import androidx.compose.ui.geometry.Offset
import com.example.pokeapiapp.data.remote.response.Pokemon
import com.example.pokeapiapp.data.remote.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {
    @GET("Pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ):Pokemon
}