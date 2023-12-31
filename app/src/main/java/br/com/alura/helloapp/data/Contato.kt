package br.com.alura.helloapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        Usuario::class,
        parentColumns = ["idUsuario"],
        childColumns = ["idUsuario"],
        onDelete = ForeignKey.CASCADE //apaga os dados relacionados
    )]
)
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nome: String = "",
    val sobrenome: String = "",
    val telefone: String = "",
    val fotoPerfil: String = "",
    val aniversario: Date? = null,
    @ColumnInfo(defaultValue = "") //evita problema de criar campo novo com valores null
    val idUsuario: String = "" //chave estrangeira no Contato
)