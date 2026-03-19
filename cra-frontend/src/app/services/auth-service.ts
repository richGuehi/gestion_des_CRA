import { Injectable } from '@angular/core';
import { BaseService } from './base-service';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService extends BaseService{
  protected override endpoint = '/auth';

  login(credentials: { email: string; password: string }) {
    return this.post<any>(credentials, '/login').pipe(
      tap(response => {
        localStorage.setItem('token', response.token); 
      })
    );
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
  }
}