package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Positive;

public class TelefonePacienteTO {
    //Atributos
    private Long idTelefone;
    @NotNull
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idPaciente;
    @NotNull
    @Min(value = 11, message = "DDD inválido. Deve ser maior ou igual a 11.")
    @Max(value = 99, message = "DDD inválido. Deve ser menor ou igual a 99.")
    private int ddd;
    @NotNull
    @Positive(message = "O ID deve ser um número positivo.")
    @Min(value = 10000000, message = "O número deve ter pelo menos 8 dígitos.")
    @Max(value = 999999999, message = "O número deve ter no máximo 9 dígitos.")
    private int numero;
    //construtores
    public TelefonePacienteTO() {
    }

    public TelefonePacienteTO(Long idTelefone, Long idPaciente, int ddd, int numero) {
        this.idTelefone = idTelefone;
        this.idPaciente = idPaciente;
        this.ddd = ddd;
        this.numero = numero;
    }
    //metodos getters/setters
    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
