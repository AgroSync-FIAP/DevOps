import React from 'react';
import Button from "@/components/Button";
import Card from "@/components/Card";
import NavBar from "@/components/NavBar";
import { PlusCircleIcon } from '@heroicons/react/24/outline';

// Sample data (you can replace this with your actual data)
const sampleData = [
  { id: 1, title: "Card 1", description: "Description for Card 1" },
  { id: 2, title: "Card 2", description: "Description for Card 2" },
  { id: 3, title: "Card 3", description: "Description for Card 3" },
];

export default function AnalysisOfImages() {
  return (
    <>
      <NavBar active={"analysisOfImages"} />

      <main className="green-pastel-light mt-5 m-20 p-4">
        <div className="grid md:grid-cols-2 md:grid-rows-1 gap-2 m-4 space-x-96 justify-between items-center">
          <h2 className="text-green-pea-800 text-4xl">AnalysisOfImages</h2>

          <Button icon={<PlusCircleIcon className="h-6 w-6" />} href="/analysisOfImages/new">Criar AnalysisOfImages</Button>
        </div>

        <div className="grid gap-10 grid-cols-3">
          {sampleData.map(analysisOfImages => (
            <Card key={analysisOfImages.id} analysisOfImages={analysisOfImages} />
          ))}
        </div>
      </main>
    </>
  );
}
