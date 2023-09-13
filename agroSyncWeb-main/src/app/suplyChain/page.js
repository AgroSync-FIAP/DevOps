import Head from 'next/head';

// Dados fictícios de pedidos para demonstração
const fakeOrders = [
    {
        id: 1,
        product: 'Produto A',
        status: 'Em andamento',
        location: 'Fábrica 1',
    },
    {
        id: 2,
        product: 'Produto B',
        status: 'Em trânsito',
        location: 'Centro de Distribuição 1',
    },
    {
        id: 3,
        product: 'Produto C',
        status: 'Entregue',
        location: 'Cliente 1',
    },
];

export default function SupplyChain() {
    return (
        <div>
            <Head>
                <title>Controle de Supply Chain</title>
            </Head>
            <main className="container mx-auto mt-8 p-4">
                <h1 className="text-3xl font-semibold mb-4">Controle de Supply Chain</h1>
                <table className="table-auto w-full">
                    <thead>
                        <tr>
                            <th className="px-4 py-2">ID</th>
                            <th className="px-4 py-2">Produto</th>
                            <th className="px-4 py-2">Status</th>
                            <th className="px-4 py-2">Localização</th>
                        </tr>
                    </thead>
                    <tbody>
                        {fakeOrders.map((order) => (
                            <tr key={order.id}>
                                <td className="border px-4 py-2">{order.id}</td>
                                <td className="border px-4 py-2">{order.product}</td>
                                <td className="border px-4 py-2">{order.status}</td>
                                <td className="border px-4 py-2">{order.location}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </main>
        </div>
    );
}
