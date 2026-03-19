import { Routes } from '@angular/router';
import { User } from './components/user/user';
import { Login } from './components/login/login';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
    { path: 'login', component: Login },
    { 
        path : 'collaborateurs', 
        component : User,
        //active le guard
        canActivate: [authGuard]
    },

    // default
    { path: '', redirectTo: 'login', pathMatch: 'full' }
];
