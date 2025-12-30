import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface AdminCredentials {
  adminUsername: string;
  adminPassword: string;
}

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private apiUrl = 'http://localhost:8080/admin/dashboard';

  constructor(private http: HttpClient) {}

  verifyAdmin(username: string, password: string): Observable<boolean> {
    const params = new HttpParams()
      .set('adminUsername', username)
      .set('adminPassword', password);

    return this.http.get<boolean>(this.apiUrl, { params });
  }
}
