import {React,useState} from 'react';
import axios from 'axios';

export const Signup = () =>{
    const [userData, setUserData] = useState({
        username: '',
        email: '',
        password: '',
    });

    const inputdata = async (e) =>{
        const { name, value } = e.target;
        console.log(value)
        setUserData((prevUserData) => ({
            ...prevUserData,
            [name]: value,      
        }));
    }

   const UserSignUp = async () =>{
        try{
            const reponse = await axios.post('https:localhost8080', userData)
        }catch(err){

        }
   }

    return (
        <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
            <div className="max-w-md w-full mx-auto p-8 bg-white shadow-md rounded-md">
                <h2 className="text-2xl font-bold text-gray-800 mb-4 text-center">Sign Up for ChatRooms</h2>
                <form className="space-y-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Username</label>
                        <input
                        type="text"
                        name="username"
                        placeholder="Username"
                        className="w-full border-gray-300 rounded-md shadow-sm p-2"
                        onChange={inputdata}
                        />
                    </div>
                    <div>
                        <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email</label>
                        <input
                        type="email"
                        name="email"
                        placeholder="Email"
                        className="w-full border-gray-300 rounded-md shadow-sm p-2"
                        onChange={inputdata}
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700">Password</label>
                        <input
                        type="password"
                         name="password"
                        placeholder="Password"
                        className="w-full border-gray-300 rounded-md shadow-sm p-2"
                        onChange={inputdata}
                        />
                    </div>
                    <button className="bg-blue-500 hover:bg-blue-600 text-white font-medium py-2 px-4 rounded-md" onClick={() => UserSignUp(userData)}>
                        Sign Up
                    </button>
            
                    <h3 className="text-center">
                        Already have an account?<br/>
                        <a href="/signin" className="text-blue-500 hover:text-blue-600">
                        Sign in here!
                        </a>
                    </h3>
                </form>
            </div>
        </div>
    );
   }  