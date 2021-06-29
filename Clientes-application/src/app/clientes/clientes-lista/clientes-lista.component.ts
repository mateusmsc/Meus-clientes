import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Router } from '@angular/router';
import { Cliente } from '../Cliente';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {


  clientes: Cliente[] = [];
  clienteSelecionado: Cliente;
  mensagemSucesso: String;
  mensagemError: String;

  constructor(
    private service: ClientesService
    , private router: Router) { }

  // Populando o componente
  ngOnInit(): void {
    // A variável de array de clientes
    // é iniciada pelo retorno do serviço 
    // dos clientes;
    this
      .service
      .getClientes()
      .subscribe(resposta => this.clientes = resposta);
  }

  novoCadastro() {
    this.router.navigate(['/clientes-form'])
  }

  pepraraDelecao(cliente: Cliente) {
    this.clienteSelecionado = cliente;
  }

  deletarCliente() {
    this.service
      .deletar(this.clienteSelecionado)
      .subscribe(reponse => {
        this.mensagemSucesso = "Cliente excluído com sucesso",
        this.ngOnInit();
      },
        errorResponse => this.mensagemError = "Erro ao excluir o cliente");
  }
}
