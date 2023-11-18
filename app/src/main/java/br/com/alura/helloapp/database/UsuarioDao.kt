package br.com.alura.helloapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.alura.helloapp.data.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insere(usuario: Usuario)

    @Query("SELECT * FROM usuario")
    fun buscaTodos(): Flow<List<Usuario>>

    @Query("SELECT * FROM usuario WHERE idUsuario = :usuario")
    fun buscaPorId(usuario: String): Flow<Usuario?>

    @Update
    suspend fun atualiza(usuario: Usuario)

    @Delete
    suspend fun apaga(usuario: Usuario)
}