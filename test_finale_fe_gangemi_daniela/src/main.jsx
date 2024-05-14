import "bootstrap-icons/font/bootstrap-icons.css"
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.bundle"
import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom"
import { Login } from "./pages/Login/Login"
import { NotFound } from "./pages/NotFound/NotFound"
import { AuthContextProvider } from "./context/AuthContext/AuthContextProvider"
import { Home } from "./pages/Home/Home"
import { Layout } from "./components/Layouts/MainLayout/Layout"
import { ProtectedRoute } from "./components/ProtectedRoute"
import { UserRegistration } from "./pages/UserRegistration/UserRegistration"

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />
  },
  {
    path: "/registration",
    element: <UserRegistration />
  },
  {
    element: <AuthContextProvider><Layout /></AuthContextProvider>,
    path: "/home",
    children: [
      {
        path: "",
        element: <ProtectedRoute><Home /></ProtectedRoute>
      },
    ]

  },
  {
    path: "*",
    element: <NotFound />
  }

]);

ReactDOM.createRoot(document.getElementById('root')).render(

  <RouterProvider router={router} />

)
