import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';


export abstract class BaseService {
  
  //pour recuperer le http client sans le constructeur
  protected http = inject(HttpClient)
 
  // pour les endpoint des services
  protected abstract endpoint: string;

  protected get url(): string {
    return `${environment.apiUrl}${this.endpoint}`;
  }

  // methode generique
  protected get<T>( path: string = ''): Observable<T> {
    return this.http.get<T>(`${this.url}${path}`);
  }

  protected post<T>(data: any, path: string = ''): Observable<T> {
    return this.http.post<T>(`${this.url}${path}`, data);
  }

  protected put<T>(id: number | string, data : any , path: string = ''): Observable<T> {
    return this.http.put<T>(`${this.url}${path}/${id}`, data);
  }

  protected delete<T>(id: number | string , path: string = ''): Observable<T> {
    return this.http.delete<T>(`${this.url}${path}/${id}`);
  }

}
