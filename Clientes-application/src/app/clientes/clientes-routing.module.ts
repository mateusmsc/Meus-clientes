import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';

// Criação e declaração das rotas 

const routes: Routes = [
  // path: Caminho por onde essa rota será acessada
  // componente: Qual será o componente renderizado nessa rota
  { path: 'clientes-form', component: ClientesFormComponent},
  //adicionando uma nova rota com o id como parâmetro de url
  { path: 'clientes-form/:id', component: ClientesFormComponent},
  { path: 'clientes-lista', component: ClientesListaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
