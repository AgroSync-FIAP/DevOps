
import { ArrowRightCircleIcon } from '@heroicons/react/24/outline'

export default function Card({analysisOfImages}) {
    return (
        <div>
            <div class="grid md:grid-cols-2 md:grid-rows-1 md:p-1 gap-10 rounded-md bg-green justify-center items-center">
                <div id="data" class="md:col-span-1">
                    <div id="data-col" class="p-4">
                        <div class="mb-auto">
                            <span class="font-bold text-xl">{analysisOfImages.titulo}</span>
                        </div>
                        <div class="mb-2">
                            <span>{analysisOfImages.descricao}</span>
                        </div>
                        <div class="grid md:grid-cols-2 mt-auto">
                            <span class="text-green-800">Ver mais</span>
                            <ArrowRightCircleIcon className="h-6 w-6 text-green-600" />
                        </div>
                    </div>
                </div>
                <div class="md:col-auto flex justify-center items-center">
                    <div class="mb-4 mt-3">
                        <img src="farm.png" alt="Imagem" class="w-auto h-auto" />
                    </div>
                </div>
            </div>
        </div>
    )
}