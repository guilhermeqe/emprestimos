package br.com.tqi.emprestimos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "solicitacao_emprestimo")
public class SolicitacaoEmprestimo {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusSolicitacaoEmprestimo status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusSolicitacaoEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacaoEmprestimo status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoEmprestimo that = (SolicitacaoEmprestimo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
