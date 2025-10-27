package br.com.fiap.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ConsultaTO {
    //Atributos
    private Long idConsulta;
    @NotNull
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idUnidade;
    @NotNull
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idPaciente;
    @NotNull
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idMedico;
    @PastOrPresent(message = "A data deve ser no passado, ou hoje.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dtConsulta;
    //construtores

    public ConsultaTO() {
    }

    public ConsultaTO(Long idConsulta, Long idUnidade, Long idPaciente, Long idMedico, LocalDate dtConsulta) {
        this.idConsulta = idConsulta;
        this.idUnidade = idUnidade;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.dtConsulta = dtConsulta;
    }
    //metodos getters/setters
    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public LocalDate getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(LocalDate dtConsulta) {
        this.dtConsulta = dtConsulta;
    }
}
