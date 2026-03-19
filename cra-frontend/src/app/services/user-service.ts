import { Injectable } from '@angular/core';
import { BaseService } from './base-service';
import { UserModel } from '../models/user.models';

@Injectable({
  providedIn: 'root',
})
export class UserService extends BaseService{
  protected override endpoint = '/users'
  
  getAllUsers() {
    return this.get<UserModel[]>('');
  }

  createUser(user : UserModel){
    return this.post<UserModel>(user, '');
  }
}
