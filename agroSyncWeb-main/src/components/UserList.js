// components/UserList.js
import React from "react";

const UserList = ({ users, onDelete, onEdit }) => {
  return (
    <div>
      <h2>Lista de Usuários</h2>
      <table className="table-fixed w-full">
        <thead>
          <tr>
            <th className="w-1/4">Nome</th>
            <th className="w-1/4">Email</th>
            <th className="w-1/4">Ações</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>
                <button onClick={() => onEdit(user.id)} className="mr-2">
                  Editar
                </button>
                <button onClick={() => onDelete(user.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserList;
