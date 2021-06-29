import { Injectable } from '@angular/core';
import { Cliente } from './clientes/Cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NONE_TYPE } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor( private http :HttpClient) { }

  salvar ( cliente : Cliente) :Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }
  
  getClientes() : Observable <Cliente []> {
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  getClientesById(id: number) :Observable<Cliente>{
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }

  // retornando um Observable de any pois a resposta do backend não retorna nada 
  atualizar ( cliente : Cliente) :Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente);
  }

  deletar( cliente: Cliente) :Observable<any>{
    return this.http.delete<any>(`http://localhost:8080/api/clientes/${cliente.id}`);
  }

}
