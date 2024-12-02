import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Goal } from '../models/Goal';

const baseUrl = 'http://localhost:8080/api/goals';//will need to be changed

@Injectable({
  providedIn: 'root'
})
export class GoalsService {

  constructor(private http: HttpClient) { }

  getAllGoals(userId: any): Observable<Goal[]> {
    return this.http.get<Goal[]>(baseUrl);
  }

  getGoal(userId: any, goalId: any): Observable<Goal> {
    return this.http.get<Goal[]>(baseUrl);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(goalId: any, data: any): Observable<any> {
      return this.http.put(`${baseUrl}/${goalId}`, data);
  }

  delete(goalId: any) {
    return this.http.delete<Goal[]>(`${baseUrl}/${goalId}`);
  }
}
