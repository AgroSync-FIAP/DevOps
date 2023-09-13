"use client"

import { create } from "@/actions/obras";
import Button from "@/components/Button";
import NavBar from "@/components/NavBar";
import TextInput from "@/components/TextInput";
import { ArrowLeftIcon, CheckIcon } from "@heroicons/react/24/outline";
import { useState } from "react";
import { redirect } from 'next/navigation'

export default function FormObra() {

    const [message, setMessage] = useState("")
    
    //tratalhando o estado do message
    async function handleSumit(formData){
        const resp = await create(formData)
        if (resp.error){
            setMessage(resp.error)
            return
        }
        redirect("/analysisOfImages")
        // redirect é para direcionar ao finalizar. Se tudo der certo
    }

    return (
        <>
            <NavBar active={"analysisOfImages"} />
            <main className="green-pastel-light mt-10 p-2 rounded max-w-lg m-auto bg-">
                <h1 className="=tex-green text-40"> Cadastrar Obra </h1>

                <form action={handleSumit}>
                    <TextInput name="titulo" id="titulo" label="titulo" />
                    <TextInput name="descricao" id="descricao" label="descricao" />
                    
                    <div className="flex justify-around">
                        <Button href="/obra" variant="tertiary" icon={<ArrowLeftIcon className="h6 w-6" />} >Cancelar</Button>
                        <Button element="button" variant="secundary" icon={<CheckIcon className="h6 w-6" />}>
                            Salvar
                        </Button>
                    </div>

                    <p>{message}</p>
                </form>
            </main>

        </>

    )
}