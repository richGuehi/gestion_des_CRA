import { Routes } from '@angular/router';
import { User } from './components/user/user';
import { Login } from './components/login/login';
import { authGuard } from './guards/auth.guard';
import { Dashboard } from './components/dashboard/dashboard';

export const routes: Routes = [
    { path: 'login', component: Login },
    { 
        path : 'collaborateurs', 
        component : User,
        //active le guard
        canActivate: [authGuard]
    },
    { 
        path: 'dashboard', 
        component: Dashboard, 
        canActivate: [authGuard] 
    },

    // default
    { path: '', redirectTo: 'login', pathMatch: 'full' }
];
