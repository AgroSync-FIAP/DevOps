// pages/soil-analysis.js
import NavBar from "@/components/NavBar";
import Head from 'next/head';

export default function SoilAnalysis() {
  // const handleSubmit = (e) => {
  //   e.preventDefault();
  //   // Aqui você pode adicionar a lógica para processar os dados do solo
  //   // e enviá-los para o servidor.
  //   console.log('Dados de análise de solo enviados.');
  // };

  return (
    <div>
      <NavBar active={"analysisOfSoil"} />
      
      <Head>
        <title>Análise de Solo</title>
      </Head>
      <main className="container mx-auto mt-8 p-4">
        <h1 className="text-3xl font-semibold mb-4">Análise de Solo</h1>
        <form onSubmit={''}>
          <div className="mb-4">
            <label htmlFor="location" className="block font-semibold mb-2">
              Localização:
            </label>
            <input
              type="text"
              id="location"
              name="location"
              className="border border-gray-300 p-2 w-full rounded"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="phLevel" className="block font-semibold mb-2">
              Nível de pH:
            </label>
            <input
              type="text"
              id="phLevel"
              name="phLevel"
              className="border border-gray-300 p-2 w-full rounded"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="nutrientLevels" className="block font-semibold mb-2">
              Níveis de Nutrientes:
            </label>
            <textarea
              id="nutrientLevels"
              name="nutrientLevels"
              className="border border-gray-300 p-2 w-full rounded"
              required
            ></textarea>
          </div>
          <button
            type="submit"
            className="bg-green-pea-500 text-white font-semibold py-2 px-4 rounded hover:bg-green-pea-600"
          >
            Enviar Análise de Solo
          </button>
        </form>
      </main>
    </div>
  );
}
