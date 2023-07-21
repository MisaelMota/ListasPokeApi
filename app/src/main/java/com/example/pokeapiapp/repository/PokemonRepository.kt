package com.example.pokeapiapp.repository


import com.example.pokeapiapp.data.remote.PokeApi
import com.example.pokeapiapp.data.remote.response.Pokemon
import com.example.pokeapiapp.data.remote.response.PokemonList
import com.example.pokeapiapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api:PokeApi
) {
    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokemonList>{
        val response=try {
            api.getPokemonList(limit, offset)
        }catch (e:Exception){
            return Resource.Error("Ha ocurrido un error.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(PokemonName:String):Resource<Pokemon>{
        val response=try {
            api.getPokemonInfo(PokemonName)
        }catch (e:Exception){
            return Resource.Error("Ha ocurrido un error.")
        }
        return Resource.Success(response)
    }
}