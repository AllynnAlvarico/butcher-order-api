import { Routes } from '@angular/router';
import { LoginPage } from './page/login-page/login-page';
import { Dashboard } from './page/dashboard/dashboard';

export const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginPage },
  {path: 'dashboard', component: Dashboard}
];
