import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interface for admin credentials
/**
 * AdminCredentials interface represents the structure of admin login credentials.
 * - adminUsername: The username of the admin.
 * - adminPassword: The password of the admin.
 */
export interface AdminCredentials {
  adminUsername: string;
  adminPassword: string;
}
// @Injectable decorator marks this class as available to be provided and injected as a dependency.
// Meaning this service can be injected into components or other services throughout the application.
@Injectable({
  providedIn: 'root'
})
// AdminService handles admin-related operations, such as verifying admin credentials.
export class AdminService {
  // Test API endpoint for admin verification
  private apiUrl = 'http://localhost:8080/admin/dashboard';

  constructor(private http: HttpClient) {}

  /**
   * Verify admin credentials by sending a GET request to the backend.
   * @param username
   * @param password
   * @returns Observable<boolean> indicating whether the credentials are valid.
   */
  verifyAdmin(username: string, password: string): Observable<boolean> {
    const params = new HttpParams()
      .set('adminUsername', username)
      .set('adminPassword', password);
    // this returns an Observable that emits a boolean value indicating the verification result
    // The backend is expected to respond with true or false based on the validity of the credentials
    return this.http.get<boolean>(this.apiUrl, { params });
  }
}
